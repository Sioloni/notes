package ru.neotoria.gempl.microservices.common_service.util;

public class FunctionalInterfaces {
	@FunctionalInterface
	public interface Setter<IN> {
		void action(IN in);
	}

	@FunctionalInterface
	public interface Getter<OUT> {
		OUT action();
	}
}
