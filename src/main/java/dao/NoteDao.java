package dao;

import entity.note;

public interface NoteDao {
    void addNote(note Note);
    note[] allNote();
    void deleNote(String NoteId);
    note[] findNoteBN(String Title);
    note findNoteBI(String NoteId);
    void changeNote(note Note);
}
