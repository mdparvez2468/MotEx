package com.example.motex.fragments;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.motex.R;
import com.example.motex.SearchActivity;
import com.example.motex.adapters.CategoryAdapter;
import com.example.motex.adapters.TopProductAdapter;
import com.example.motex.models.Product;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {



    ImageSlider imageSlider;

    RecyclerView homeCategoryRecyclerview;
    RecyclerView homeTopProductRecyclerview;
    List<Product> categories;
    List<Product> topProducts;
    CategoryAdapter categoryAdapter;
    TopProductAdapter topProductAdapter;

    LinearLayout searchLL;

    ImageButton pScan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        searchLL = view.findViewById(R.id.searchLL);

        pScan = view.findViewById(R.id.pScan);

        homeCategoryRecyclerview = view.findViewById(R.id.homeCategoryRecyclerview);
        homeTopProductRecyclerview = view.findViewById(R.id.homeTopProductRecyclerview);
        homeCategoryRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        homeTopProductRecyclerview.setLayoutManager(new GridLayoutManager(getContext(),3));

        categories = new ArrayList<>();
        topProducts = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(categories);
        topProductAdapter = new TopProductAdapter(topProducts);
        homeCategoryRecyclerview.setAdapter(categoryAdapter);
        homeTopProductRecyclerview.setAdapter(topProductAdapter);

        imageSlider = view.findViewById(R.id.image_slider);
        final List<SlideModel> images = new ArrayList<>();

        images.add(new SlideModel(R.drawable.slider_1, ScaleTypes.FIT));
        images.add(new SlideModel(R.drawable.slider_2, ScaleTypes.FIT));
        images.add(new SlideModel(R.drawable.slider_3, ScaleTypes.FIT));
        images.add(new SlideModel(R.drawable.slider_4, ScaleTypes.FIT));
        images.add(new SlideModel(R.drawable.slider_5, ScaleTypes.FIT));

        imageSlider.setImageList(images);



        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Toast.makeText(getContext(), ""+i, Toast.LENGTH_SHORT).show();
            }
        });



        categories.add(new Product(1,R.drawable.category1,"Medicines"));
        categories.add(new Product(2,R.drawable.cayegory2,"Tests"));
        categories.add(new Product(3,R.drawable.category3,"Aks Doctor"));
        categories.add(new Product(4,R.drawable.category4,"Baby care"));
        categories.add(new Product(5,R.drawable.category5,"Personal Care"));
        categories.add(new Product(6,R.drawable.category6,"Health Care"));
        categories.add(new Product(1,R.drawable.category1,"Medicines"));
        categories.add(new Product(2,R.drawable.cayegory2,"Tests"));
        categories.add(new Product(3,R.drawable.category3,"Aks Doctor"));
        categories.add(new Product(4,R.drawable.category4,"Baby care"));
        categories.add(new Product(5,R.drawable.category5,"Personal Care"));
        categories.add(new Product(6,R.drawable.category6,"Health Care"));
        categories.add(new Product(1,R.drawable.category1,"Medicines"));
        categories.add(new Product(2,R.drawable.cayegory2,"Tests"));
        categories.add(new Product(3,R.drawable.category3,"Aks Doctor"));
        categories.add(new Product(4,R.drawable.category4,"Baby care"));
        categories.add(new Product(5,R.drawable.category5,"Personal Care"));
        categories.add(new Product(6,R.drawable.category6,"Health Care"));



        topProducts.add(new Product(1,R.drawable.p1,"Rex6mg+200mg+50mgTablet Square Pharmaceuticals Ltd.","$20","$30"));
        topProducts.add(new Product(1,R.drawable.p2,"E-Cap 400400mg Capsule Drug International Ltd.","$40","$30"));
        topProducts.add(new Product(1,R.drawable.p3,"Kiton Soap50gm Soap Biotec Corporation Generic: Ketoconazole","$55","$60"));
        topProducts.add(new Product(1,R.drawable.p4,"Nevralip 600 Retard600mg Tablet River Pharma Generic: Acido Alfa Lipoico","$30","$35"));
        topProducts.add(new Product(1,R.drawable.p5,"Biovera Body Lotion100gm Lotion Biotec Corporation","$20","$32"));
        topProducts.add(new Product(1,R.drawable.p6,"Nestlé Lactogen 1 Infant Formula Milk Powder BIB (0-6 Months)350gm","$15","$18"));
        topProducts.add(new Product(1,R.drawable.p7,"Rex6mg+200mg+50mgTablet Square Pharmaceuticals Ltd.","$20","$35"));
        topProducts.add(new Product(1,R.drawable.p8,"Kiton Soap50gm Soap Biotec Corporation Generic: Ketoconazole","$10","$20"));
        topProducts.add(new Product(1,R.drawable.p9,"Nevralip 600 Retard600mg Tablet River Pharma Generic: Acido Alfa Lipoico","$45","$50"));
        topProducts.add(new Product(1,R.drawable.p10,"E-Cap 400400mg Capsule Drug International Ltd.","50","$30"));
        topProducts.add(new Product(1,R.drawable.p11,"Nestlé Lactogen 1 Infant Formula Milk Powder BIB (0-6 Months)350gm","22","$65"));
        topProducts.add(new Product(1,R.drawable.p12,"Biovera Body Lotion100gm Lotion Biotec Corporation","$40","$50"));
        topProducts.add(new Product(1,R.drawable.p13,"Rex6mg+200mg+50mgTablet Square Pharmaceuticals Ltd.","$10","$20"));
        topProducts.add(new Product(1,R.drawable.p14,"Kiton Soap50gm Soap Biotec Corporation Generic: Ketoconazole","$50","$70"));
        topProducts.add(new Product(1,R.drawable.p15,"E-Cap 400400mg Capsule Drug International Ltd.","$35","$40"));
        topProducts.add(new Product(1,R.drawable.p17,"Nevralip 600 Retard600mg Tablet River Pharma Generic: Acido Alfa Lipoico","$20","$30"));
        topProducts.add(new Product(1,R.drawable.p1,"Nestlé Lactogen 1 Infant Formula Milk Powder BIB (0-6 Months)350gm","$40","$50"));
        topProducts.add(new Product(1,R.drawable.p2,"Rex6mg+200mg+50mgTablet Square Pharmaceuticals Ltd.","$10","$20"));
        topProducts.add(new Product(1,R.drawable.p3,"Biovera Body Lotion100gm Lotion Biotec Corporation","$40","$50"));
        topProducts.add(new Product(1,R.drawable.p4,"Kiton Soap50gm Soap Biotec Corporation Generic: Ketoconazole","$10","$20"));
        topProducts.add(new Product(1,R.drawable.p5,"Nestlé Lactogen 1 Infant Formula Milk Powder BIB (0-6 Months)350gm","$20","$30"));
        topProducts.add(new Product(1,R.drawable.p6,"Nevralip 600 Retard600mg Tablet River Pharma Generic: Acido Alfa Lipoico","$40","$50"));
        topProducts.add(new Product(1,R.drawable.p7,"E-Cap 400400mg Capsule Drug International Ltd.","$50","$60"));
        topProducts.add(new Product(1,R.drawable.p8,"Rex6mg+200mg+50mgTablet Square Pharmaceuticals Ltd.","$10","$20"));
        topProducts.add(new Product(1,R.drawable.p9,"Nestlé Lactogen 1 Infant Formula Milk Powder BIB (0-6 Months)350gm","$20","$30"));
        topProducts.add(new Product(1,R.drawable.p10,"Biovera Body Lotion100gm Lotion Biotec Corporation","$30","$35"));
        topProducts.add(new Product(1,R.drawable.p11,"Kiton Soap50gm Soap Biotec Corporation Generic: Ketoconazole","$20","$32"));
        topProducts.add(new Product(1,R.drawable.p12,"E-Cap 400400mg Capsule Drug International Ltd.","$50","$60"));
        topProducts.add(new Product(1,R.drawable.p13,"Nevralip 600 Retard600mg Tablet River Pharma Generic: Acido Alfa Lipoico","$10","$20"));
        topProducts.add(new Product(1,R.drawable.p14,"Rex6mg+200mg+50mgTablet Square Pharmaceuticals Ltd.","$40","$50"));






        categoryAdapter.notifyDataSetChanged();
        topProductAdapter.notifyDataSetChanged();

        searchLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });

        pScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkRunTimePermission("camera")){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,101);
                }else {
                    requestRunTimePermission("camera");
                }
            }
        });

        return view;
    }

    private boolean checkRunTimePermission(String name) {

        if (name.equals("location")){
            return ActivityCompat.checkSelfPermission(getContext(),ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        } else if (name.equals("camera")) {
            return ActivityCompat.checkSelfPermission(getContext(),CAMERA) == PackageManager.PERMISSION_GRANTED;
        } else if (name.equals("readImage")) {
            return ActivityCompat.checkSelfPermission(getContext(),READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }

        return false;
    }
    private void requestRunTimePermission(String name) {
        if (name.equals("location")){
            ActivityCompat.requestPermissions(getActivity(),new String[]{ACCESS_FINE_LOCATION},401);
        }else if (name.equals("camera")){
            ActivityCompat.requestPermissions(getActivity(),new String[]{CAMERA},402);
        }else if (name.equals("readImage")){
            ActivityCompat.requestPermissions(getActivity(),new String[]{READ_EXTERNAL_STORAGE},403);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 401){
            if (grantResults.length>0){
                if ( grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(getContext(), "Permission ERROR!!", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == 402){
            if (grantResults.length>0){
                if ( grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,101);
                }else {

                    Toast.makeText(getContext(), "CAMERA Permission Denied", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(getContext(), "CAMERA Permission ERROR!!", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == 403){
            if (grantResults.length>0){
                if ( grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent,102);
                }else {

                    Toast.makeText(getContext(), "Storage Permission Denied", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(getContext(), "Storage Permission ERROR!!", Toast.LENGTH_SHORT).show();
            }
        }
    }


}