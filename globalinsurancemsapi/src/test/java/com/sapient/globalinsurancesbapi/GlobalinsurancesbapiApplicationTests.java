package com.sapient.globalinsurancesbapi;
/*
import com.sapient.globalinsurancesbapi.models.FullName;
import com.sapient.globalinsurancesbapi.models.Gender;
import com.sapient.globalinsurancesbapi.models.Owner;
import com.sapient.globalinsurancesbapi.repositories.OwnerRepository;
import com.sapient.globalinsurancesbapi.services.FakeOwnerService;
import com.sapient.globalinsurancesbapi.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GlobalinsurancesbapiApplicationTests {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerService ownerService;

    private Owner owner;


    @Mock
    private Hashtable<Integer,Owner> ownerHashtable;

    @Captor
    private ArgumentCaptor<Integer> keyCaptor;

    @Captor
    private ArgumentCaptor<Owner> valueCaptor;

    @Spy
    private List<Owner> ownerList= FakeOwnerService.getAllOwners();

    @BeforeEach
    public void createOwner() {
        owner=new Owner(38254852,new FullName("param","","Bala"),
                Gender.FEMALE,"param@gmail.com");

        Optional<Owner> ownerObj= Optional.of(owner);
        //stub
        //preconfigured response
        when(ownerRepository.findById(338254852L)).thenReturn(ownerObj);
    }


    @Test
    public void getOwnerByMobileNo(){

        assertTrue(ownerService.getOwnerById(338254852L).getName().getFirstName().equals("param"));
    }


    @Test
   public void captureHashTableKeyAndValue(){
        Owner ownerObj=new Owner(38254349767L,new FullName("param","","Bala"),
                Gender.FEMALE,"param@gmail.com");
        ownerHashtable.put(1,ownerObj);
        //spying
        Mockito.verify(ownerHashtable).put(keyCaptor.capture(), valueCaptor.capture());
        assertEquals(1, keyCaptor.getValue());

        assertEquals(ownerObj, valueCaptor.getValue());

   }
   @Test
   public void testFakeListWithSpy(){
       ownerList.add(new Owner(38254349767L,new FullName("param","","Bala"),
               Gender.FEMALE,"param@gmail.com"));
       ownerList.add(new Owner(38254349778L,new FullName("param","","Bala"),
               Gender.FEMALE,"param@gmail.com"));

      //spying
       Mockito.verify(ownerList).add(new Owner(38254349767L,new FullName("param","","Bala"),
               Gender.FEMALE,"param@gmail.com"));
       Mockito.verify(ownerList).add(new Owner(38254349778L,new FullName("param","","Bala"),
               Gender.FEMALE,"param@gmail.com"));

       assertEquals(102, ownerList.size());
   }


    //mockito throw test
    @Test
    void testMockitoThrows() {
        Properties properties = Mockito.mock(Properties.class);

        when(properties.get(Mockito.anyString())).thenThrow(new IllegalArgumentException("dbparams error"));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> properties.get("url"));

        assertEquals("dbparams error", exception.getMessage());
    }
}
*/