package tech.ibit.web.springboot.exception;

/**
 * 定义参数异常
 *
 * @author IBIT TECH
 */
public interface DefaultErrorCode extends ErrorCode {

    /**
     * 定义前缀
     */
    int CP = DEFAULT_CODE_PREFIX;


    /**
     * 参数缺失
     */
    interface ParameterMissing {
        int CODE = CP + 1;
        String MESSAGE = CODE + SPLIT + "参数缺失";
    }


    /**
     * 参数类型错误
     */
    interface ParameterTypeError {
        int CODE = CP + 2;
        String MESSAGE = CODE + SPLIT + "参数类型错误";
    }


    /**
     * 参数校验错误
     */
    interface ParameterValidError {
        int CODE = CP + 3;
        String MESSAGE = CODE + SPLIT + "参数校验错误";
    }


    /**
     * 参数类型错误
     */
    interface ParameterBindError {
        int CODE = CP + 4;
        String MESSAGE = CODE + SPLIT + "参数绑定错误";
    }


    /**
     * 资源不存在
     */
    interface NotFound {
        int CODE = CP + 5;
        String MESSAGE = CODE + SPLIT + "资源不存在";
    }


    /**
     * 消息不可读
     */
    interface MessageNotReadable {
        int CODE = CP + 6;
        String MESSAGE = CODE + SPLIT + "消息不可读";
    }


    /**
     * 方法不支持
     */
    interface MethodNotSupported {
        int CODE = CP + 7;
        String MESSAGE = CODE + SPLIT + "方法不支持";
    }


    /**
     * 流媒体类型不支持
     */
    interface MediaTypeNotSupported {
        int CODE = CP + 8;
        String MESSAGE = CODE + SPLIT + "流媒体类型不支持";
    }

}
