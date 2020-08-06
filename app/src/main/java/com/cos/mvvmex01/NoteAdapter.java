package com.cos.mvvmex01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.mvvmex01.databinding.NoteItemBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    class NoteHolder extends RecyclerView.ViewHolder {

        // 이거 사용하려면 먼저 build.gradle에 databinding enable = true 설정 후 프로젝트 rebuild 하기
       private NoteItemBinding noteItemBinding;

        public NoteHolder(@NonNull NoteItemBinding noteItemBinding){
            super(noteItemBinding.getRoot());
            this.noteItemBinding = noteItemBinding;
        }
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NoteItemBinding noteItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.note_item,
                parent,
                false
        );
        return new NoteHolder(noteItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.noteItemBinding.setNote(currentNote);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position){
        return notes.get(position);
    }
}
