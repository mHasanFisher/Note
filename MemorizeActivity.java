package memorizeappwithdbflow.fisher.com.memorizeappwithdbflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MemorizeActivity extends AppCompatActivity {

    private EditText subject;
    private EditText text;
    private Organization org;
    private List<Organization> orgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize);

        subject = (EditText) findViewById(R.id.subject);
        text = (EditText) findViewById(R.id.mainText);
    }

    @Override
    public void onBackPressed() {

        orgList = SQLite.select().from(Organization.class).queryList();
        org = new Organization();

        int id = (orgList.size()) + 1;
        org.setId(id);
        org.setName(subject.getText().toString());
        org.setText(text.getText().toString());
        org.save();

        Intent intent = new Intent(MemorizeActivity.this, MainActivity.class);
        finish();
        startActivity(intent);

    }
}
