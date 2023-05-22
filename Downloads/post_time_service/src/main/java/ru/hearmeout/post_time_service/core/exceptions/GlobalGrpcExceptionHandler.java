package ru.hearmeout.post_time_service.core.exceptions;

import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class GlobalGrpcExceptionHandler implements ServerInterceptor {
    private final Metadata.BinaryMarshaller<String> STRING_MARSHALLER = new Metadata.BinaryMarshaller<>() {
        @Override
        public byte[] toBytes(String value) {
            return value.getBytes(StandardCharsets.UTF_8);
        }

        @Override
        public String parseBytes(byte[] serialized) {
            return new String(serialized);
        }
    };

    private Metadata getMetadata(HMOException ex) {
        final Metadata metadata = new Metadata();

        ex.getData().forEach((k, v) -> metadata.put(
                Metadata.Key.of(k, STRING_MARSHALLER),
                v.toString()
        ));
        return metadata;
    }

    private <ReqT, RespT> void close(ServerCall<ReqT, RespT> call, HMOException ex) {
        call.close(
                ex.getError().getStatus(),
                getMetadata(ex)
        );
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata requestHeaders, ServerCallHandler<ReqT, RespT> next) {
        ServerCall.Listener<ReqT> delegate = next.startCall(call, requestHeaders);
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<>(delegate) {
            @Override
            public void onHalfClose() {
                try {
                    super.onHalfClose();
                } catch (HMOException e) {
                    close(call, e);
                } catch (Exception e) {
                    HMOException localException = HMOException.of(e);
                    close(call, localException);
                }
            }
        };
    }
}
