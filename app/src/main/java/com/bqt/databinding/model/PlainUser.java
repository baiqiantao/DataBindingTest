package com.bqt.databinding.model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class PlainUser {
	public final ObservableField<String> name = new ObservableField<>();
	public final ObservableInt age = new ObservableInt();
}
