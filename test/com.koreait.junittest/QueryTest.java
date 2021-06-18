package com.koreait.junittest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTest {
    @BeforeAll
    public void beforeAll() {
        Query.createTable();
    }

    @AfterAll
    public void afterAll()
    {
        Query.dropTable();
    }

    @BeforeEach
    public void beforeEacj() {
        Query.boardDelete(0);

        BoardVO vo1 = new BoardVO();
        vo1.setBtitle("Pak");
        vo1.setBcontent("Lindsy");
        Query.boardInsert(vo1);

        BoardVO vo2 = new BoardVO();
        vo1.setBtitle("Min");
        vo1.setBcontent("Lindsy2");
        Query.boardInsert(vo2);
    }

    @Test
    public void testA() {
        BoardVO vo1 = Query.getBoardDetail(1);
        assertEquals(vo1.getBtitle(), "Pak");
        assertEquals(vo1.getBcontent(), "Lindsy");
        BoardVO vo2 = Query.getBoardDetail(2);
        assertEquals(vo2.getBtitle(), "Min");
        assertEquals(vo2.getBcontent(), "Lindsy2");
    }

    @Test
    public void testB() {}

    @Test
    public void testC() {}
}
