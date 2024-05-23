package main.sensoryexperimentplatform.ViewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.sensoryexperimentplatform.models.Notice;

public class RunNotice_VM {
    private Notice notice;
    private StringProperty title, content;

    public RunNotice_VM(Notice notice){
        this.notice = notice;
        title = new SimpleStringProperty(notice.getTitle());
        content = new SimpleStringProperty(notice.getContent());
    }
    public StringProperty getTitle(){
        return title;
    }
    public StringProperty getContent(){
        return content;
    }
    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}
