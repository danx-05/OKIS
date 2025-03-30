from codecs import strict_errors

import pytest
from src.class_for_test import CLASS

class TestMatrixPower:
    @pytest.mark.fast
    def test_matrix_power_zero(self):
        matrix = [[2, 1], [2, 3]]
        result = CLASS.matrix_power(matrix, 0)
        expected = [[1, 0], [0, 1]]
        assert result == expected

    @pytest.mark.fast
    def test_matrix_power_one(self):
        matrix = [[2, 1], [2, 3]]
        result = CLASS.matrix_power(matrix, 1)
        assert result == matrix


    @pytest.mark.parametrize("sp,expected", [
        ([-1,-2, 2, 3,-4, 20], 21),
        ([-2,-2,-4,-23,-1], -1),
        ([-3,-2,4,2,1,4,-3,2,-12,4], 11),
    ])

    def test_max_subarray(self, sp, expected):
        result = CLASS.max_subarray(sp)
        assert result == expected

    @pytest.mark.fast
    def test_recurrence_Fibb(self):
        a = 1
        b = -1
        c = -1
        n = 4
        result = CLASS.solve_recurrence(a,b,c,n)
        expected = 3
        assert result == expected

    @pytest.mark.fast
    def test_recurrence(self):
        a = 1
        b = -4
        c = 4
        n = 3
        result = CLASS.solve_recurrence(a,b,c,n)
        expected = 12
        assert result == expected


    # исключение обрабатывает
    @pytest.mark.exceptions
    def test_mult_matrix_with_exeptions(self):
        a = [[1, 2, 3], [4, 5, 6]]  # 2x3
        b = [[1, 2], [3, 4]]  # 2x2

        with pytest.raises(ValueError) as error:
            CLASS.matrix_mult(a, b)

        assert "Умножение матриц невозможно: несовместимые размеры" in str(error.value)

    @pytest.mark.exceptions
    @pytest.mark.fast
    def test_matrix_pow_with_exeptions(self):
        a = [[1, 2, 3], [4, 5, 6]]

        with pytest.raises(ValueError) as error:
            CLASS.matrix_power(a, 5)

        assert "Матрица должна быть квадратной" in str(error.value)

    def test_mult_matr(self):
        a = [[1,0],[0,1]]
        b = [[1,2],[3,4]]
        result = CLASS.matrix_mult(a,b)
        expected = [[1,2],[3,4]]
        assert result == expected

    @pytest.mark.parametrize("sp,expected", [
        ([[2,1],[2,3],[6,3],[6,1]], 8),
        ([[1,1], [1,5],[5,2]], 8),
        ([[1,1],[1,3],[2,3],[4,5],[7,5],[5,3],[5,1]], 14),
    ])
    def test_square(self, sp, expected):
        result = CLASS.Square(sp)
        assert result == expected
