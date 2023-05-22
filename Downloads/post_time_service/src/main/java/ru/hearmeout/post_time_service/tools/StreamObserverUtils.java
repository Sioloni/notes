package ru.hearmeout.post_time_service.tools;

import io.grpc.stub.StreamObserver;
import lombok.experimental.UtilityClass;


@UtilityClass
public class StreamObserverUtils {
	public <T> void submit(
			StreamObserver<T> observer, T data
	) {
		observer.onNext(data);
		observer.onCompleted();
	}
}
