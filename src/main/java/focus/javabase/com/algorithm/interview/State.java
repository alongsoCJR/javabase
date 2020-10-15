package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description mt机试题 状态模式
 * @Date 2020-10-15 22:41
 **/
public class State {

    public static final String INIT_STATE = "草稿状态";
    public static final String AWAiTING_AUDIT_STATE = "待审核状态";
    public static final String AUDITED_STATE = "审核通过状态";
    public static final String REFUSED_STATE = "审核驳回状态";
    public static final String VALID_STATE = "生效状态";
    public static final String OVER_STATE = "淘汰状态";
    private String state;

    // 写草稿
    public void write() throws Exception {
        // write
        if (state == null || state == OVER_STATE) {
            state = INIT_STATE;
        } else {
            throw new Exception("非法操作，目前处于不合法状态！");
        }
    }

    // 写完草稿提交
    public void commit() throws Exception {
        if (state == INIT_STATE || state == REFUSED_STATE) {
            // commit
            state = AWAiTING_AUDIT_STATE;
        } else {
            throw new Exception("非法操作，目前处于不合法状态！");
        }
    }

    // 审核通过操作
    public void auditSuccess() throws Exception {
        if (state == AWAiTING_AUDIT_STATE) {
            state = AUDITED_STATE;
        } else {
            throw new Exception("非法操作，目前处于不合法状态！");
        }
    }

    // 审核拒绝操作
    public void auditRefuse() throws Exception {
        if (state == AWAiTING_AUDIT_STATE) {
            state = REFUSED_STATE;
        } else {
            throw new Exception("非法操作，目前处于不合法状态！");
        }
    }

    // 激活操作
    public void valid() throws Exception {
        if (state == AUDITED_STATE) {
            state = VALID_STATE;
        } else {
            throw new Exception("非法操作，目前处于不合法状态！");
        }
    }

    // 管理员审核拒绝
    public void refuse() throws Exception {
        if (state == VALID_STATE) {
            state = OVER_STATE;
        } else {
            throw new Exception("非法操作，目前处于不合法状态！");
        }
    }


}
