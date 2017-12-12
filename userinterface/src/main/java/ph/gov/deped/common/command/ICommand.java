package ph.gov.deped.common.command;

/**
 * Created by ej on 8/20/14.
 */
public interface ICommand<C extends IContext<? extends IRequest, ? extends IResponse>> {

    void execute(C context);
}
