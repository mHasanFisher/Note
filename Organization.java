package memorizeappwithdbflow.fisher.com.memorizeappwithdbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Mohammad Hasan on 6/16/2017.
 */

@Table(database = mydb.class)
public class Organization extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    String name;

    @Column
    String texts;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Organization organization;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String texts) {
        this.texts = texts;
    }

}
