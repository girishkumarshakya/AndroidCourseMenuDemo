package in.lavit.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        registerForContextMenu(textView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,imageView);
                popupMenu.getMenuInflater().inflate(R.menu.main_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id){
                            case R.id.action_copy:
                                Toast.makeText(MainActivity.this, "Copy is clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_paste:
                                Toast.makeText(MainActivity.this, "paste is clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_signout:
                                Toast.makeText(MainActivity.this, "Signout is clicked", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_copy:
                Toast.makeText(this, "Copy is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_paste:
                Toast.makeText(this, "paste is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_signout:
                Toast.makeText(this, "Signout is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_copy:
                Toast.makeText(this, "Copy is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_paste:
                Toast.makeText(this, "paste is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_signout:
                Toast.makeText(this, "Signout is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);

    }
}
