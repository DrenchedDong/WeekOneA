package dongting.bwei.com.weekonea.bean;

/**
 * 作者:${董婷}
 * 日期:2017/6/10
 * 描述:
 */

public class ABean {
    private String title ;
    private int a;
    private String content;

    public ABean(String title, String content, int a) {
        this.title = title;
        this.content = content;
        this.a = a;
    }

    public ABean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
