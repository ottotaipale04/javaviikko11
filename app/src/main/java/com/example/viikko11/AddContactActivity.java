package com.example.viikko11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {

    private EditText firstName, lastName, phoneNumber;
    private Button addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.GroupText), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstName = findViewById(R.id.FirstNameEdit);
        lastName = findViewById(R.id.LastNameEdit);
        phoneNumber = findViewById(R.id.PhoneNumberEdit);
        addContact = findViewById(R.id.AddContactButton);
    }

    public void addContact(View view) {
        String nameFirst = firstName.getText().toString();
        String nameLast = lastName.getText().toString();
        String number = phoneNumber.getText().toString();

        RadioGroup contactTypeRadio = findViewById(R.id.ContactTypeRadioGroup);
        int selectedId = contactTypeRadio.getCheckedRadioButtonId();
        String contactGroup = "";

        if (selectedId == R.id.PersonalRadioButton) {
            contactGroup = "Henkilökohtainen";
        } else if (selectedId == R.id.WorkRadioButton) {
            contactGroup = "Työ";
        }

        Contact newContact = new Contact(nameFirst, nameLast, number, contactGroup);
        ContactStorage.getInstance().addContact(newContact);

        finish();
    }
}