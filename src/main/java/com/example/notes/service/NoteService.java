package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(String id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(String id, Note updatedNote) {
        return noteRepository.findById(id)
                .map(existingNote -> {
                    existingNote.setTitle(updatedNote.getTitle());
                    existingNote.setContent(updatedNote.getContent());
                    existingNote.setUpdatedAt(LocalDateTime.now());
                    return noteRepository.save(existingNote);
                }).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteNoteById(String id) {
        noteRepository.deleteById(id);
    }
}
