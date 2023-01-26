import java.util.*;

public class MatricialInsightUtils {
    static List<Insight> itemsToInsightList(
        Map<InsightType, List<String>> insightItems,
        String improvementInsightsPrefix,
        String strengthInsightsPrefix
    ) {
        List<Insight> insightsList = new ArrayList<>();

        List<String> improvementItems = insightItems.get(InsightType.IMPROVEMENT_AXIS);
        if (improvementItems != null && improvementItems.size() > 0) {
            String improvementInsightValue = improvementInsightsPrefix + String.join(", ", improvementItems) + ".";
            insightsList.add(new Insight(InsightType.IMPROVEMENT_AXIS, improvementInsightValue));
        }

        List<String> strengthItems = insightItems.get(InsightType.STRENGTH);
        if (strengthItems != null && strengthItems.size() > 0) {
            String strengthInsightValue = strengthInsightsPrefix + String.join(", ", strengthItems) + ".";
            insightsList.add(new Insight(InsightType.STRENGTH, strengthInsightValue));
        }

        return insightsList;
    }
}

enum InsightType {
    STRENGTH, IMPROVEMENT_AXIS, SELLING_OPPORTUNITY
}

record Insight(InsightType type, String value) {
}
