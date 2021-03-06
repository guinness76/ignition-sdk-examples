package com.inductiveautomation.examples;

import com.inductiveautomation.ignition.common.TypeUtilities;
import com.inductiveautomation.ignition.common.expressions.Expression;
import com.inductiveautomation.ignition.common.expressions.ExpressionException;
import com.inductiveautomation.ignition.common.expressions.functions.AbstractFunction;
import com.inductiveautomation.ignition.common.model.values.BasicQualifiedValue;
import com.inductiveautomation.ignition.common.model.values.QualifiedValue;

/**
 * This class is placed in the common package to allow the expression to be used by both a gateway expression tag
 * and as the expression in a designer/client property binding.
 */
public class MultiplyFunction extends AbstractFunction {

    @Override
    public Class<?> getType() {
        return Integer.class;
    }

    @Override
    protected String getFunctionDisplayName() {
        // This String shows up in logs as "Function 'exampleMultiply' ..." if there is an error when executing
        // the expression
        return "exampleMultiply";
    }

    @Override
    public String getArgDocString() {
        // This String shows in in the Designer when selecting the expression.
        return "value, multiplier";
    }

    @Override
    public QualifiedValue execute(Expression[] expressions) throws ExpressionException {
        // First user-supplied value of the expression
        QualifiedValue theValueQV = expressions[0].execute();
        int theValue = TypeUtilities.toInteger(theValueQV.getValue());

        // Second user-supplied value of the expression
        QualifiedValue multiplierQV = expressions[1].execute();
        int multiplier = TypeUtilities.toInteger(multiplierQV.getValue());

        return new BasicQualifiedValue(theValue * multiplier, theValueQV.getQuality());
    }
}
