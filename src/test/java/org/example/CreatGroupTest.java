package org.example;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class CreatGroupTest {

    @Test
    void creatGroup_SetNameGroup_GetNameGrop() {
        Group group = new Group();
        group.setName("GG");
        assertEquals("GG",group.getName());
    }

    @Test
    void creatGroup_CheckGropIsNotEmpty_GetTrue() {
        assertEquals(false,CreatGroup.creatGroup().getStudentList().isEmpty());
    }

    @Test
    void creatGroup_CheckCountStuden_GetTrue() {
        assertEquals(10,CreatGroup.creatGroup().getStudentList().size());
    }
}