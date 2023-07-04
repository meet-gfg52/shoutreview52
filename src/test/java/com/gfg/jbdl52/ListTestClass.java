package com.gfg.jbdl52;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ListTestClass {

    @Mock
    private List<Integer> listMock;

    @Test
    public void simpleAssertTrueTest(){
        assertTrue(2==2);
    }

    @Test
    public void simpleAssertFalseTest(){
        assertFalse(2==3);
    }

    @Test
    public void testListSize(){
        listMock=mock(ArrayList.class);
        listMock.add(1);
        when(listMock.size()).thenReturn(1);
        assertEquals(1,listMock.size());
    }

    @Test
    public void testListWrongSize(){
        listMock=mock(ArrayList.class);
        listMock.add(1);
        when(listMock.size()).thenReturn(2);
        assertNotEquals(1,listMock.size());
    }

    @Test
    public void testVerifyMethodCall(){
        listMock=mock(ArrayList.class);
        listMock.add(1);
        when(listMock.size()).thenReturn(1);
        assertEquals(1,listMock.size());
        verify(listMock,times(1)).add(anyInt());
    }
}
