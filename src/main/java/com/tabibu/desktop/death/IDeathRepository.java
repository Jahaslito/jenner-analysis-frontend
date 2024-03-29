package com.tabibu.desktop.death;

import io.reactivex.Single;
import retrofit2.Call;

import java.util.List;

public interface IDeathRepository {
    Single<List<Death>> getAllDeaths();
}
