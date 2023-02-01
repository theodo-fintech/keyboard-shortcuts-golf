import java.util.*;

public class MatricialInsightUtils {
    static List<Insight> itemsToInsightList(
        Map<InsightType, List<String>> insightItems,
        String improvementInsightsPrefix,
        String strengthInsightsPrefix
    ) {
        List<Insight> insightsList = new ArrayList<>();
        addInsight(insightItems, InsightType.IMPROVEMENT_AXIS, improvementInsightsPrefix, insightsList);
        addInsight(insightItems, InsightType.STRENGTH, strengthInsightsPrefix, insightsList);
        return insightsList;
    }

    private static void addInsight(Map<InsightType, List<String>> insightItems, InsightType type, String prefix, Collection<Insight> insights) {
        List<String> items = insightItems.get(type);
        if (items != null && items.size() > 0) {
            String value = prefix + String.join(", ", items) + ".";
            insights.add(new Insight(type, value));
        }
    }
}

enum InsightType {
    STRENGTH, IMPROVEMENT_AXIS, SELLING_OPPORTUNITY
}

record Insight(InsightType type, String value) {
}
