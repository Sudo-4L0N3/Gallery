/**
 * =================================================================================================
 * Dear Fellow Programmer,
 * <p>
 * Welcome to my code! I'm Dave, the architect behind these lines.
 * Brace yourself for a journey through logic and creativity.
 * Feel free to reach out if you have questions or ideas to share.
 * Together, let's make this code shine!
 * <p>
 * Happy coding,
 * Sudo-4L0N3
 * =================================================================================================
 */

/**
 * MainActivity is the entry point of the application, responsible for handling user login.
 * It includes input fields for username and password and a login button.
 * On successful login (when both username and password are empty), it displays a toast message
 * and starts the MainPage activity, providing access to the image gallery.
 */
package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the layout defined in activity_main.xml
        setContentView(R.layout.activity_main);

        // Initialize TextViews for username and password input
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        // Initialize the login button
        MaterialButton login = findViewById(R.id.login);

        // Set click listener for the login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Check if both username and password are empty (dummy check for demonstration)
                if (username.getText().toString().equals("") && password.getText().toString().equals("")) {

                    // Display a toast message for no input detected
                    Toast.makeText(MainActivity.this, "Please Enter your username and password", Toast.LENGTH_SHORT).show();
                }
                else if (username.getText().toString().equals("admin") && password.getText().toString().equals("")) {
                    // Display a toast message if not password detected
                    Toast.makeText(MainActivity.this, "Please Enter your password", Toast.LENGTH_SHORT).show();
                }
                else if (username.getText().toString().equals("") && password.getText().toString().equals("admin")) {
                    // Display a toast message if not password detected
                    Toast.makeText(MainActivity.this, "Please Enter your Username", Toast.LENGTH_SHORT).show();
                }
                else if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    // Display a toast message for successful login
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    //Reset the Input after login
                    username.setText("");
                    password.setText("");

                    // Start the MainPage.java activity
                    //after login successful It will open the main content inside using this block
                    Intent intent = new Intent(MainActivity.this, MainPage.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Welcome Senpai", Toast.LENGTH_SHORT).show();


                } else {
                    // Display a toast message for failed login
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Check your username or password", Toast.LENGTH_SHORT).show();

                    //Reset the Input if it failed
                    username.setText("");
                    password.setText("");

                }
            }
        });
    }
}
