package Variables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Type2ComplexSummarizer {
    private List<Type2SimpleSummarizer> listOfSummarizers; //size = N
    private List<String> conjunctions; //size = N - 1

}
