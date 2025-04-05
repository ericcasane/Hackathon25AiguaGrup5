package com.tecnocampus.aquaactua;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tecnocampus.aquaactua.chat.ChatApi;
import com.tecnocampus.aquaactua.chat.ChatResponse;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatFragment extends Fragment {

    private EditText etQuestion;
    private TextView tvAnswer;

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etQuestion = view.findViewById(R.id.etQuestion);
        tvAnswer = view.findViewById(R.id.tvAnswer);

        etQuestion.setOnEditorActionListener((v, actionId, event) -> {
            boolean isEnter = actionId == EditorInfo.IME_ACTION_SEND ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN);
            if (isEnter) {
                String question = etQuestion.getText().toString().trim();
                if (!question.isEmpty()) {
                    sendQuestionToApi(question);
                }
                return true;
            }
            return false;
        });
    }

    private void sendQuestionToApi(String question) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChatApi chatApi = retrofit.create(ChatApi.class);

        // El cuerpo debe ser un string entre comillas dobles para que sea JSON válido
        String jsonQuestion = "\"" + question + "\"";

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                jsonQuestion
                );

        chatApi.sendQuestion(body).enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(@NonNull Call<ChatResponse> call, @NonNull Response<ChatResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    tvAnswer.setText(response.body().getAnswer());
                } else {
                    tvAnswer.setText("Error al obtener respuesta.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ChatResponse> call, @NonNull Throwable t) {
                tvAnswer.setText("Error de conexión: " + t.getMessage());
            }
        });
    }
}
