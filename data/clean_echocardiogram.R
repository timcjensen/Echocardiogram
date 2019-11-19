
library(dplyr)

HeartData <- read.csv( "echocardiogram.csv" )

(
  HeartData
  %>%select( -c( mult, name, group, alive.at.1 ) )
  %>%filter( !( survival < 12 & still.alive == 1 ) )
  %>%mutate( target = case_when( survival >= 12 ~ 1, TRUE ~ 0 ) )
  %>%select( -c( survival, still.alive ) )
  ->FinalHeartData
)

write.csv( FinalHeartData, file = "Echocardiogram_Cleaned.csv", row.names = FALSE )