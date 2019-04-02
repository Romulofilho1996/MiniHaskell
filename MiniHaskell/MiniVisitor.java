// Generated from Mini.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniVisitor<T> extends ParseTreeVisitor<T> {

	T visitIfExpression(MiniParser.IfExpressionContext ctx);

	T visitParenthesisExpression(MiniParser.ParenthesisExpressionContext ctx);

	T visitLogicNotExpression(MiniParser.LogicNotExpressionContext ctx);

	T visitGreaterEqualExpression(MiniParser.GreaterEqualExpressionContext ctx);

	T visitApplyFuncExpression(MiniParser.ApplyFuncExpressionContext ctx);

	T visitGreaterThanExpression(MiniParser.GreaterThanExpressionContext ctx);

	T visitIntegerExpression(MiniParser.IntegerExpressionContext ctx);

	T visitIdentifierExpression(MiniParser.IdentifierExpressionContext ctx);

	T visitLessEqualExpression(MiniParser.LessEqualExpressionContext ctx);

	T visitSubtractionExpression(MiniParser.SubtractionExpressionContext ctx);

	T visitTrueExpression(MiniParser.TrueExpressionContext ctx);

	T visitLogicAndExpression(MiniParser.LogicAndExpressionContext ctx);

	T visitLogicOrExpression(MiniParser.LogicOrExpressionContext ctx);

	T visitLetExpression(MiniParser.LetExpressionContext ctx);

	T visitSumExpression(MiniParser.SumExpressionContext ctx);

	T visitDivisionExpression(MiniParser.DivisionExpressionContext ctx);

	T visitMultiplicationExpression(MiniParser.MultiplicationExpressionContext ctx);

	T visitFalseExpression(MiniParser.FalseExpressionContext ctx);

	T visitLessThanExpression(MiniParser.LessThanExpressionContext ctx);
	T visitEqualsExpression(MiniParser.EqualsExpressionContext ctx);

	T visitFunctionDeclaration(MiniParser.FunctionDeclarationContext ctx);

	T visitFormalParameters(MiniParser.FormalParametersContext ctx);

	T visitFormalParameter(MiniParser.FormalParameterContext ctx);
}