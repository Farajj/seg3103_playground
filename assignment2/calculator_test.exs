defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  ### percentage_grade tests (and sample) ###

  describe "percentage_grade/1" do
    test "sample" do
      assert 85 ==
               Calculator.percentage_grade(%{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               })
    end
  end

  describe "percentage_grade/2" do
    test "TC1" do
      assert 41 ==
               Calculator.percentage_grade(%{
                 homework: [],
                 labs: [],
                 midterm: 0.70,
                 final: 0.9
               })
    end
  end

  ### letter_grade tests ###

  describe "letter_grade/1" do
    test "TC2" do
      assert "F" ==
               Calculator.letter_grade(%{
                 homework: [0.4],
                 labs: [0.25, 0.25, 0.25],
                 midterm: 0.4,
                 final: 0.4
               })
    end
  end

  describe "letter_grade/2" do
    test "TC3" do
      assert "EIN" ==
               Calculator.letter_grade(%{
                 homework: [],
                 labs: [0.9],
                 midterm: 0.2,
                 final: 0.4
               })
    end
  end



  ### numeric_grade tests ###

  describe "numeric_grade/1" do
    test "TC4" do
      assert 0 ==
              Calculator.numeric_grade(%{
                homework: [0.4],
                labs: [0.25, 0.25, 0.25],
                midterm: 0.4,
                final: 0.4
              })
    end
  end

  describe "numeric_grade/2" do
    test "TC5" do
      assert "EIN" ==
               Calculator.letter_grade(%{
                 homework: [],
                 labs: [0.9],
                 midterm: 0.2,
                 final: 0.4
               })
    end
  end

end
