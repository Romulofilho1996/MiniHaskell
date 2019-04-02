// Generated from Mini.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link MiniVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class MiniBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MiniVisitor<T> {

	@Override public T visitIfExpression(MiniParser.IfExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitParenthesisExpression(MiniParser.ParenthesisExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicNotExpression(MiniParser.LogicNotExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreaterEqualExpression(MiniParser.GreaterEqualExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitApplyFuncExpression(MiniParser.ApplyFuncExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitGreaterThanExpression(MiniParser.GreaterThanExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitIntegerExpression(MiniParser.IntegerExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitIdentifierExpression(MiniParser.IdentifierExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessEqualExpression(MiniParser.LessEqualExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitSubtractionExpression(MiniParser.SubtractionExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitTrueExpression(MiniParser.TrueExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitLogicAndExpression(MiniParser.LogicAndExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitLogicOrExpression(MiniParser.LogicOrExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitLetExpression(MiniParser.LetExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitSumExpression(MiniParser.SumExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitDivisionExpression(MiniParser.DivisionExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitMultiplicationExpression(MiniParser.MultiplicationExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitFalseExpression(MiniParser.FalseExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitLessThanExpression(MiniParser.LessThanExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitEqualsExpression(MiniParser.EqualsExpressionContext ctx) { return visitChildren(ctx); }

	@Override public T visitFunctionDeclaration(MiniParser.FunctionDeclarationContext ctx) { return visitChildren(ctx); }

	@Override public T visitFormalParameters(MiniParser.FormalParametersContext ctx) { return visitChildren(ctx); }

	@Override public T visitFormalParameter(MiniParser.FormalParameterContext ctx) { return visitChildren(ctx); }
}