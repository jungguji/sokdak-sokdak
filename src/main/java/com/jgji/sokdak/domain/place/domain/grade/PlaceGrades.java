package com.jgji.sokdak.domain.place.domain.grade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PlaceGrades {

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<PlaceGrade> grades = new ArrayList<>();

    public PlaceGrades(List<PlaceGrade> grades) {
        this.grades = grades;
    }

    public Double getGrade() {
        if (this.grades.isEmpty()) {
            return null;
        }

        return this.grades
            .stream()
            .mapToDouble(PlaceGrade::getGradeTotal)
            .average()
            .getAsDouble();
    }
}
