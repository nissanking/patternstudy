package dsl.decisiontable;

import java.util.ArrayList;
import java.util.List;

public class DecisionTable<TI, TO> {

    private List<Condition<TI>> conditions = new ArrayList<Condition<TI>>();

    private List<Column<TO>>    columns    = new ArrayList<Column<TO>>();

    private List<String> conditionNames = new ArrayList<String>();

    public List<Condition<TI>> getConditions() {
        return conditions;
    }

    public List<Column<TO>> getColumns() {
        return columns;
    }
    
    public void addCondition(String description, Condition.TestType<TI> test) {
        conditions.add(new Condition<TI>(description, test));
    }

    public List<String> getConditionNames() {
        return conditionNames ;
    }

    public void addColumn(ConditionBlock conditions, TO consequences) {
        if (hasConditionBlock(conditions)) {
            throw new IllegalStateException("duplicate condition");
        }
        columns.add(new Column<TO>(conditions, consequences));
    }

    private boolean hasConditionBlock(ConditionBlock conditions) {
        for (Column<TO> column : columns) {
            if (column.getConditions().matches(conditions)) {
                return true;
            }
        }
        
        return false;
    }
    
    public TO run(TI arg) {
        
    }

}
