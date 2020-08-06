package com.cos.mvvmex01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {

    // LiveData는 함수를 getter만 있음
    // MutableLiveData는 함수를 getter, setter를 가지고 있음.
    private MutableLiveData<List<Note>> allNotes = new MutableLiveData<>();

    public NoteRepository(){
        List<Note> notes = new ArrayList<>();
        allNotes.setValue(notes);
    }

    public LiveData<List<Note>> findAll(){
        return allNotes;
    }

    public void delete(Note note){
        List<Note> notes = allNotes.getValue();
        notes.remove(note);
        allNotes.setValue(notes);
    };

    public void save(Note note){
        List<Note> notes = allNotes.getValue();
        notes.add(note);
        allNotes.setValue(notes);
    };
}
