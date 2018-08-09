package gsy.main.enumtest;

/**
 * @author gongshiyun
 * @Description TODO
 * @date 2018/7/6
 */
public enum Color {

    RED{
        public String getName(){
            return "red";
        }
    },
    YELLOW{
        public String getName(){
            return "yellow";
        }
    },
    GREEN{
        public String getName(){
            return "green";
        }
    };

    public abstract String getName();
}
