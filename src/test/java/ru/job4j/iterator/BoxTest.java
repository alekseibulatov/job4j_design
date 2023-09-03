package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .doesNotContainIgnoringCase("Tetrahedron")
                .startsWithIgnoringCase("s")
                .endsWithIgnoringCase("e")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isNotBlank()
                .isNotEqualTo("Sphere")
                .startsWithIgnoringCase("t")
                .endsWithIgnoringCase("n")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isNumberVertexSphere() {
        Box box = new Box(0, 15);
        int numberVertexSphere = box.getNumberOfVertices();
        assertThat(numberVertexSphere).isZero()
                .isEven()
                .isLessThan(1)
                .isEqualTo(0);
    }

    @Test
    void isNumberVertexCube() {
        Box box = new Box(8, 2);
        int numberVertexCube = box.getNumberOfVertices();
        assertThat(numberVertexCube).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(7)
                .isEqualTo(8);
    }

    @Test
    void isExistCube() {
        Box box = new Box(8, 2);
        boolean existCube = box.isExist();
        assertThat(existCube).isNotEqualTo(false)
                .isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(7, 3);
        boolean existBox = box.isExist();
        assertThat(existBox).isNotEqualTo(true)
                .isFalse();
    }

    @Test
    void isAreaCube() {
        Box box = new Box(8, 4);
        double areaCube = box.getArea();
        assertThat(areaCube).isEqualTo(96.0d, withPrecision(0.01d))
                .isGreaterThan(50.0d);
    }

    @Test
    void isAreaTetrahedron() {
        Box box = new Box(4, 7);
        double areaTetrahedron = box.getArea();
        assertThat(areaTetrahedron).isEqualTo(84.8d, withPrecision(0.1d))
                .isLessThan(85.0d);
    }

    @Test
    void isNotAreaBox() {
        Box box = new Box(5, 9);
        double notAreaBox = box.getArea();
        assertThat(notAreaBox).isEqualTo(0.0d)
                .isZero();
    }
}