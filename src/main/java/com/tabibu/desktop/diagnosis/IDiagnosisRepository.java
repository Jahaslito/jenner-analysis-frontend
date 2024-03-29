package com.tabibu.desktop.diagnosis;

import io.reactivex.Single;

import java.util.List;

public interface IDiagnosisRepository {
    Single<List<Diagnosis>> getAllDiagnosis();
}
