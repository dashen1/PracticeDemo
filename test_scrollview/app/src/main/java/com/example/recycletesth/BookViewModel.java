package com.example.recycletesth;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class BookViewModel {

  private final MutableLiveData<List<Book>> bookListLiveData = new MutableLiveData<>();
}
