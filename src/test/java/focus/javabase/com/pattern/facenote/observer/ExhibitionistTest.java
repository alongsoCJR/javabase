package focus.javabase.com.pattern.facenote.observer;

import focus.javabase.com.pattern.facenote.Exhibitionist;
import org.junit.Test;

public class ExhibitionistTest {

    /**
     * @return void
     * @Author chenjianrong-lhq
     * @Description： 观察者模式 一对多发送消息 MQ就是利用这个原理的
     * @Date 2019-07-25 21:00
     * @Param []
     **/
    @Test
    public void update() {
        Exhibitionist exhibitionist = new Exhibitionist();
        Costomer costomer = new Costomer(exhibitionist);
        Voyeur voyeur = new Voyeur(exhibitionist);
        exhibitionist.trigger("表演者上场，掌声在哪里！");
    }
}