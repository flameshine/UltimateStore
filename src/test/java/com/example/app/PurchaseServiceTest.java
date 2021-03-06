package com.example.app;

import java.util.List;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.PurchaseServiceImpl;
import com.example.app.repository.PurchaseRepository;
import com.example.app.entity.Purchase;
import com.example.app.util.TestData;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class PurchaseServiceTest extends AbstractTestNGSpringContextTests {

    // all tests temporarily disabled and will be replaced with the special Spring Boot tests.

    @InjectMocks
    private PurchaseServiceImpl testTarget;

    @Mock
    private PurchaseRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(enabled = false, dataProviderClass = TestData.class, dataProvider = "purchases")
    public void testFindAll(List<Purchase> expected) {

        doReturn(expected).when(repository).findAll();

        var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(enabled = false, dataProviderClass = TestData.class, dataProvider = "purchase")
    public void testSave(Purchase purchase) {

        testTarget.save(purchase);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(enabled = false, dataProviderClass = TestData.class, dataProvider = "purchase")
    public void testDelete(Purchase purchase) {

        testTarget.deleteById(purchase.getId());

        verify(repository, atLeastOnce()).deleteById(any());
    }
}