import java.util.HashMap;
import java.util.Map;
 
public class EvalVisitor extends MiniBaseVisitor<Double> {
    Map<String, Double> memory = new HashMap<String, Double>();
     
    @Override public Double visitIfExpression(MiniParser.IfExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitParenthesisExpression(MiniParser.ParenthesisExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitLogicNotExpression(MiniParser.LogicNotExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitGreaterEqualExpression(MiniParser.GreaterEqualExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitApplyFuncExpression(MiniParser.ApplyFuncExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitGreaterThanExpression(MiniParser.GreaterThanExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitIntegerExpression(MiniParser.IntegerExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitIdentifierExpression(MiniParser.IdentifierExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitLessEqualExpression(MiniParser.LessEqualExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitSubtractionExpression(MiniParser.SubtractionExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitTrueExpression(MiniParser.TrueExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitLogicAndExpression(MiniParser.LogicAndExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitLogicOrExpression(MiniParser.LogicOrExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitLetExpression(MiniParser.LetExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitSumExpression(MiniParser.SumExpressionContext ctx) { 
        double left = visit(ctx.expression(0));
        double right = visit(ctx.expression(1)); 
        return left + right;
    }

    @Override public Double visitDivisionExpression(MiniParser.DivisionExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitMultiplicationExpression(MiniParser.MultiplicationExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitFalseExpression(MiniParser.FalseExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitLessThanExpression(MiniParser.LessThanExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitEqualsExpression(MiniParser.EqualsExpressionContext ctx) { return visitChildren(ctx); }

    @Override public Double visitFunctionDeclaration(MiniParser.FunctionDeclarationContext ctx) { return visitChildren(ctx); }

    @Override public Double visitFormalParameters(MiniParser.FormalParametersContext ctx) { return visitChildren(ctx); }

    @Override public Double visitFormalParameter(MiniParser.FormalParameterContext ctx) { return visitChildren(ctx); }
}