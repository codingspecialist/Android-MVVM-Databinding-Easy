package com.cos.mvvmex01;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    // ViewModel 가진 데이터!!
    private LiveData<List<Note>> allNotes;
    private NoteRepository noteRepository = new NoteRepository();

    public NoteViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Note>> 구독하기(){
        return allNotes;
    }

    public void 추가하기(Note note){
        noteRepository.save(note);
    }

    public void 삭제하기(Note note){
        noteRepository.delete(note);
    }

    public void 전체데이터갱신하기(){
        allNotes = noteRepository.findAll();
    }
}
