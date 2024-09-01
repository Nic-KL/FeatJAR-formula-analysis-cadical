/*
 * Copyright (C) 2024 FeatJAR-Development-Team
 *
 * This file is part of FeatJAR-formula-analysis-cadical.
 *
 * formula-analysis-cadical is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3.0 of the License,
 * or (at your option) any later version.
 *
 * formula-analysis-cadical is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with formula-analysis-cadical. If not, see <https://www.gnu.org/licenses/>.
 *
 * See <https://github.com/FeatureIDE/FeatJAR-formula-analysis-cadical> for further information.
 */
package de.featjar.analysis.cadical.cli;

import de.featjar.analysis.cadical.computation.ComputeGetSolutionCadiCal;
import de.featjar.base.cli.OptionList;
import de.featjar.base.computation.IComputation;
import de.featjar.formula.assignment.BooleanAssignment;
import de.featjar.formula.assignment.BooleanSolution;
import de.featjar.formula.structure.IFormula;
import java.util.Optional;

public class SolutionCommand extends ACadicalAnalysisCommand<BooleanSolution, BooleanAssignment> {

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Computes a solution for a given formula using cadical");
    }

    @Override
    public IComputation<BooleanSolution> newAnalysis(OptionList optionParser, IComputation<IFormula> formula) {
        return formula.map(ComputeGetSolutionCadiCal::new);
    }

    @Override
    public String serializeResult(BooleanSolution assignment) {
        return assignment.print();
    }

    @Override
    public Optional<String> getShortName() {
        return Optional.of("solution-cadical");
    }
}
