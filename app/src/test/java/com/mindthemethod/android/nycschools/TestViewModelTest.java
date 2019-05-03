package com.mindthemethod.android.nycschools;

import com.mindthemethod.android.nycschools.data.Retrofit.GetTestData;
import com.mindthemethod.android.nycschools.data.Retrofit.RetrofitInstance;
import com.mindthemethod.android.nycschools.view.DetailActivity;
import com.mindthemethod.android.nycschools.viewmodel.TestViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        manifest = "app/src/main/AndroidManifest.xml",
        sdk = 16)
public class TestViewModelTest {
    private DetailActivity detailActivity;

    private GetTestData testData;

    @Mock
    private TestViewModel testViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ActivityController<DetailActivity> detailActivityController = Robolectric.buildActivity(DetailActivity.class);
        detailActivity = detailActivityController.get();
        testData = RetrofitInstance.getRetrofitInstance().create(GetTestData.class);
    }

    @Test
    public void isViewModelSetterWorking() {
        //Trigger the setter
        testViewModel.setDbn("ABC123");
        //Validate
        verify(testViewModel).setDbn("ABC123");
    }
}
