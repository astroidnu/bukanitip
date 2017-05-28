package dietbisabesok.com.bukanitip.activity.addnewrequest;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.addnewrequest.service.AddNewRequestResponse;
import dietbisabesok.com.bukanitip.activity.addnewrequest.service.AddNewRequestService;
import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.data.RequestNitipData;
import dietbisabesok.com.bukanitip.helper.AppConst;
import dietbisabesok.com.bukanitip.helper.ImageHelper;
import dietbisabesok.com.bukanitip.helper.UIHelper;
import dietbisabesok.com.bukanitip.model.CountryDataModel;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.session.LoginSession;
import dietbisabesok.com.bukanitip.ui.base.ViewPresenter;
import id.zelory.compressor.Compressor;
import id.zelory.compressor.FileUtil;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class AddNewRequestPresenter extends ViewPresenter<AddNewRequestView> {
    @Inject
    Gson gson;

    @Inject
    LoginSession mLoginSession;

    @Inject
    AddNewRequestService mAddNewRequestService;

    @Inject
    CountryDataModel mCountryDataModel;

    private static final int REQUEST_READ_EXTERNAL_FILE_PERMISSION = 0x100;

    private AddNewRequestActivity mActivity;
    private RequestNitipData mRequestNitipData;
    private boolean mIsBudgetValid = false;
    private boolean mIsTitleValid = false;
    private boolean mIsDescriptionValid = false;
    private boolean mIsCountryValid = false;
    private boolean mIsPictureValid = false;
    private boolean mIsShippingAddressValid = false;
    private String mRequestPhotoPath = null;
    private List<String> countries = new ArrayList<>();

    public AddNewRequestPresenter(AddNewRequestActivity addNewRequestActivity) {
        mActivity  = addNewRequestActivity;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        onFinishActivity();
        for(CountryData countryData :mCountryDataModel.loadAll()){
            countries.add(countryData.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_spinner_item,countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getView().mCountrySpinner.setAdapter(adapter);
        getView().mChoosePictureReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED ) {
                        choosePicture();
                    } else {
                        ActivityCompat.requestPermissions(mActivity,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_READ_EXTERNAL_FILE_PERMISSION);
                    }
                } else {
                    choosePicture();
                }
            }
        });

        getView().mSubmitReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getView().mProgressDialog.show();
                HashMap<String, String> mParam = new HashMap<>();
                requestNitip();
                if(mIsPictureValid && mIsBudgetValid && mIsCountryValid && mIsDescriptionValid && mIsTitleValid && mIsShippingAddressValid){
                    mParam.put("email",mLoginSession.getEmail());
                    mParam.put("token",mLoginSession.getLoginToken());
                    mParam.put("user_id", mLoginSession.getUserID());
                    mParam.put("data", gson.toJson(mRequestNitipData));
                    mParam.put("image_iklan", mRequestPhotoPath);
                    addNewRequestService(mParam);
                }else{
                    getView().mProgressDialog.hide();
                    Log.e(getClass().getName(), "Not Valid Input");
                }
            }
        });
    }

    private void addNewRequestService(HashMap<String, String> param){
        mAddNewRequestService.init(param);
        mAddNewRequestService.postNewRequest(new AddNewRequestService.GetResponseCallback() {
            @Override
            public void onSuccess(AddNewRequestResponse dataList) {
                getView().mProgressDialog.hide();
                getView().setToastMsg(dataList.message).show();
            }

            @Override
            public void onError(NetworkError networkError) {
                getView().mProgressDialog.hide();
                getView().setToastMsg(networkError.getMessage()).show();
            }
        });
    }

    private void choosePicture(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        mActivity.startActivityForResult(intent, AppConst.activity_request_code.SELECT_PICTURE);
    }

    private void requestNitip(){
        mRequestNitipData = new RequestNitipData();
        isBugdetValid(getView().mBudgetReq.getText().toString());
        isValidTitle(getView().mTitleReq.getText().toString());
        isValidDescription(getView().mDescriptionReq.getText().toString());
        isValidCountry(getView().mCountrySpinner.getSelectedItem().toString());
        isValidShippingAddress(getView().mShippingAddress.getText().toString());
        Log.d(getClass().getName(),gson.toJson(mRequestNitipData));
    }

    private void onFinishActivity(){
        getView().mArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        });
    }

    public boolean isBugdetValid(String budget){
        if(android.text.TextUtils.isDigitsOnly(budget)){
            mRequestNitipData.setBugdet(budget);
            return mIsBudgetValid = true;
        }else{
           return  mIsBudgetValid = false;
        }
    }

    public boolean isValidTitle(String title){
        if(title.length() > 3){
            mRequestNitipData.setTitle(title);
            return mIsTitleValid = true;
        }else{
            return mIsTitleValid = false;
        }
    }

    public boolean isValidDescription(String title){
        if(title.length() > 3){
            mRequestNitipData.setDescription(title);
            return mIsDescriptionValid = true;
        }else{
            return mIsDescriptionValid = false;
        }
    }


    public boolean isValidCountry(String title){
        if(title.length() > 3){
            mRequestNitipData.setCountry_id(String.valueOf(mCountryDataModel.loadCountryID(title)));
            return mIsCountryValid = true;
        }else{
            return mIsCountryValid = false;
        }
    }

    public boolean isValidPicture(String path){
        if(path != null){
            return mIsPictureValid = true;
        }else{
            return mIsPictureValid = false;
        }
    }

    public boolean isValidShippingAddress(String address){
        if(address != null){
            mRequestNitipData.setShipping_address(address);
            return mIsShippingAddressValid = true;
        }else{
            return mIsShippingAddressValid = false;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AppConst.activity_request_code.SELECT_PICTURE) {
            if(resultCode == Activity.RESULT_OK){
                try{
                    final File actualImage = FileUtil.from(mActivity, data.getData());
                    Bitmap actualImageCompress = new Compressor.Builder(mActivity)
                            .setMaxWidth(800)
                            .setMaxHeight(600)
                            .setQuality(50)
                            .setCompressFormat(Bitmap.CompressFormat.PNG)
                            .build()
                            .compressToBitmap(actualImage);
                    Log.d(getClass().getName(), String.valueOf(actualImageCompress.getByteCount()));
                    saveImageInCache(actualImageCompress);
                    Glide.with(mActivity)
                            .load(actualImage)
                            .placeholder(mActivity.getResources().getDrawable(R.drawable.borobudur))
                            .into(getView().mChoosePictureReq);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean saveImageInCache(Bitmap image) {
        boolean result = false;
        try {
            ImageHelper.encodeImage(image);
            String filename = "request_photos.jpg";
            mRequestPhotoPath =  ImageHelper.encodeImage(image);
            File photo = new File(mActivity.getCacheDir(), filename);
            saveBitmapToJPG(image, photo);
            isValidPicture(mRequestPhotoPath);
            result = true;
        } catch (IOException e) {
            UIHelper.showToastMessage(mActivity.getApplicationContext(), "Cannot Save Photo").show();
        }
        return result;
    }


    private void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        stream.close();
    }


}
