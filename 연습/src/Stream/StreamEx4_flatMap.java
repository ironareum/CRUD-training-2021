package Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4_flatMap {
	public static void main(String[] args) {
//		Stream<String[]> strArrStream = Stream.of(
//				new String[] {"abc", "def", "ghi"},
//				new String[] {"ABC", "DEF", "GHI"}
//				);
//		
//		Stream<String> strStrm =strArrStream.flatMap(Arrays::stream);
//		
		String[] lineArr = {
				"Belive or not It is true",
				"Do or do not Threre is no try"
		};
		
		Stream<String> lineStream =Arrays.stream(lineArr);
//		lineStream.forEach(System.out::println);
		Stream<String> newLineStream=lineStream.flatMap(s-> Stream.of(s.split(" +")));
		newLineStream.forEach(System.out::println);
	}
}
