package focus.javabase.com.basejava.thinkinginjava.chapter1;

/**
 * @author chenjianrong-lhq 2019年06月29日 15:35:57
 * @Description: ANameType
 * @ClassName: AppTestThree
 */
public class AppTestThree {

    public static void main(String[] args) {
        ATypeName aTypeName = new ATypeName();
        System.out.println(aTypeName);
    }
}

class ATypeName {
    private String typeName;

    @Override
    public String toString() {
        return "ATypeName{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
