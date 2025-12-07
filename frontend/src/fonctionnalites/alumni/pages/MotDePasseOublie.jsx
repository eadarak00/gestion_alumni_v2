import React from 'react';
import CarteInformationFigma from '../../../composants/etudiant/CarteInformationFigma';
import FormulaireMotDePasseOublie from '../../../composants/commun/FormulaireMotDePasseOublie';

const MotDePasseOublie = () => {
    return (
        <div className="min-h-screen bg-gray-50 py-12 px-4 sm:px-6 lg:px-8">
            <div className="max-w-[1400px] mx-auto">
                <div className="flex flex-col lg:flex-row gap-16 items-center lg:items-start justify-center">
                    <div className="w-full lg:w-auto flex-shrink-0 order-2 lg:order-1">
                        <CarteInformationFigma />
                    </div>
                    <div className="w-full lg:w-auto lg:max-w-xl order-1 lg:order-2">
                        <FormulaireMotDePasseOublie />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MotDePasseOublie;
