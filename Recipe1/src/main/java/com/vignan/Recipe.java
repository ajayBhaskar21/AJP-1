package com.vignan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipeId")
	private int recipeId;
	
	@Column(name = "recipeName")
	private String recipeName;
	
	@Column(name = "ingredients")
	private String ingredients;
	
	@Column(name = "instructions")
	private String instructions;
	
	@Column(name = "difficultyLevel")
	private String difficultyLevel;
	
	public int getRecipeId() {
		return recipeId;
	}
	
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Recipe(String recipeName, String ingredients, String instructions, String difficultyLevel) {
		super();
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.difficultyLevel = difficultyLevel;
	}

	public Recipe() {

	}
}
