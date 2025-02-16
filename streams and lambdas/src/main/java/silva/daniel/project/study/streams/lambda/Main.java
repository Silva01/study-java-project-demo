import silva.daniel.project.study.streams.lambda.ToolStream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

void main( String[] args ) {
    // Brincando com Streams infinitos !!!!! Cuidado
    ToolStream.studyInfiniteStream();

    // Brincando com Streams infinitos !!!!! Cuidado, comentado pra nao executar
    //ToolStream.studyInfiniteStreamWithProblem();

    // Brincando com FlatMap
    ToolStream.studyFlatMapStream();

    // Brincando com criação de map com Stream
    ToolStream.studyCreateMapWithStream();
}
