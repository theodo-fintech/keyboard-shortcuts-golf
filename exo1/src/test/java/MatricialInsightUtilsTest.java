import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;
import org.junit.jupiter.api.Test;

class MatricialInsightUtilsTest {
    @Test
    void should_return_list_of_insights() {
        List<Insight> result = MatricialInsightUtils.itemsToInsightList(
            Map.of(
                InsightType.IMPROVEMENT_AXIS, List.of("pain", "pratique"),
                InsightType.STRENGTH, List.of("pomme", "stratégie")
            ),
            "Faut qu'on s'améliore en: ",
            "On est fort en: "
        );
        assertThat(result).contains(
            new Insight(InsightType.IMPROVEMENT_AXIS, "Faut qu'on s'améliore en: pain, pratique."),
            new Insight(InsightType.STRENGTH, "On est fort en: pomme, stratégie.")
        );
    }

    @Test
    void should_not_add_insight_for_empty_list() {
        List<Insight> result = MatricialInsightUtils.itemsToInsightList(
            Map.of(
                InsightType.IMPROVEMENT_AXIS, List.of("pain", "pratique"),
                InsightType.STRENGTH, List.of()
            ),
            "Faut qu'on s'améliore en: ",
            "On est fort en: "
        );
        assertThat(result).containsOnly(
            new Insight(InsightType.IMPROVEMENT_AXIS, "Faut qu'on s'améliore en: pain, pratique.")
        );
    }

    @Test
    void should_not_consider_any_insight_type() {
        List<Insight> result = MatricialInsightUtils.itemsToInsightList(
            Map.of(
                InsightType.IMPROVEMENT_AXIS, List.of("pain", "pratique"),
                InsightType.STRENGTH, List.of("pomme", "stratégie"),
                InsightType.SELLING_OPPORTUNITY, List.of("jambon", "saucisse")
            ),
            "So improvable: ",
            "So strong: "
        );
        assertThat(result).containsOnly(
            new Insight(InsightType.IMPROVEMENT_AXIS, "So improvable: pain, pratique."),
            new Insight(InsightType.STRENGTH, "So strong: pomme, stratégie.")
        );
    }
}
