public class WeightLossPlan {

    public static void main(String[] args) {
        // Exercise plan
        String[] exercisePlan = {
            "Weeks 1-2: Start off with light cycling for 30 minutes a day, 5 days a week. This is to get your body used to the new physical activity. You can divide it into two 15-minute sessions if you prefer.",
            "Weeks 3-4: Increase your cycling time to 45 minutes a day, 5 days a week. Try to maintain a steady pace.",
            "Weeks 5-6: Increase your cycling time to 60 minutes a day, 5 days a week. If possible, try to increase your pace.",
            "Weeks 7-8: Maintain the 60 minutes of cycling, but add some interval training. This could be 10 minutes of normal pace, then 2 minutes of fast pace, and repeat.",
            "Weeks 9-10: Continue the routine from weeks 7-8, but add one day of restorative yoga or light stretching to aid in recovery and flexibility."
        };

        // Diet plan
        String[] dietPlan = {
            "Reduce Calorie Intake: To lose weight, you need to create a calorie deficit. This means you burn more calories than you consume. Reducing your daily calorie intake by 500 calories can result in a pound of weight loss per week.",
            "Eat Balanced Meals: Make sure you're getting a balance of protein, carbohydrates, and healthy fats in your diet. Include lots of fruits and vegetables.",
            "Stay Hydrated: Drink plenty of water throughout the day. This can help control hunger and keep you hydrated during workouts.",
            "Portion Control: Be mindful of portion sizes to avoid overeating, even of healthy foods.",
            "Avoid Processed Foods: Try to eat whole, unprocessed foods as much as possible. Processed foods often contain hidden sugars and unhealthy fats.",
            "Meal Timing: Try to eat a good meal 2-3 hours before cycling for energy. A light, nutritious post-workout snack can help with recovery."
        };

        // Print out the plan
        System.out.println("Exercise Plan:\n");
        for (String exerciseWeek : exercisePlan) {
            System.out.println(exerciseWeek + "\n");
        }

        System.out.println("Diet Plan:\n");
        for (String dietTip : dietPlan) {
            System.out.println(dietTip + "\n");
        }
    }
}
