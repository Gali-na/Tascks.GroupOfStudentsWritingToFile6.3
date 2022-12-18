package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CheakFileTest {

    @Test
    void checkFile_FileIsNull_GetFalse() {
        File file = null;
        assertEquals(false, CheakFile.check(file));
    }

    @Test
    void checkFile_FileIsNotFile_GetFalse() {
        File file = new File("C:\\Users");
        assertEquals(false, CheakFile.check(file));
    }

    @Test
    void checkFile_FileIsExist_GetTrue() {
        File file = new File("First File.txt");
        assertEquals(true, CheakFile.check(file));
    }

}